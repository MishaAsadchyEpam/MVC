package myapp.services;

import myapp.entities.Dialog;
import myapp.entities.Users;
import myapp.entities.UsersDialog;
import myapp.exceptions.EntityNotFoundException;
import myapp.exceptions.UserNotAChatMemberException;
import myapp.hibernateCRUDDao.DialogHibernateCRUDDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;

public class DialogServiceTestDeleteMemberByUserId {

    // real objects
    private DialogService service;

    // mockito
    private Dialog findedDialogMock;
    private Dialog findedChatMock;
    private DialogHibernateCRUDDao dialogDao;
    private UsersDialogService usersDialogService;
    private UsersService usersService;

    @Before
    public void setUp() throws Exception
    {
        service = new DialogService();

        dialogDao = mock(DialogHibernateCRUDDao.class);
        usersDialogService = mock(UsersDialogService.class);
        usersService = mock(UsersService.class);

        ReflectionTestUtils.setField(service, "dialogDao", dialogDao);
        ReflectionTestUtils.setField(service, "usersDialogService", usersDialogService);
        ReflectionTestUtils.setField(service, "usersService", usersService);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteMemberByUserIdChatNotExist() throws Exception
    {
        anyUser();
        chatNotFound();
        try
        {
            service.deleteMemberByUserId(1, 2);
        }
        finally
        {
            verify(usersService, times(0)).find(anyInt());

            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).delete(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
        }
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteMemberByUserIdUserNotExist() throws Exception
    {
        userNotExist();
        chatWith2Members();
        try
        {
            service.deleteMemberByUserId(1, 2);
        }
        finally
        {
            verify(usersService, times(1)).find(anyInt());

            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).delete(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
        }
    }

    @Test(expected = UserNotAChatMemberException.class)
    public void testDeleteMemberByUserIdUserNotAChatMember() throws Exception
    {
        anyUser();
        chatWith2Members();
        try
        {
            service.deleteMemberByUserId(1, 4);
        }
        finally
        {
            verify(usersService, times(1)).find(anyInt());

            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).delete(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteMemberByUserIdAllIncorrect() throws Exception
    {

        try
        {
            service.deleteMemberByUserId(-1, -1);
        }
        finally
        {
            verify(dialogDao, times(0)).find(anyInt());
            verify(dialogDao, times(0)).delete(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteMemberByUserIdDialogIdIncorrect() throws Exception
    {
        try
        {
            service.deleteMemberByUserId(-1, 1);
        }
        finally
        {
            verify(dialogDao, times(0)).find(anyInt());
            verify(dialogDao, times(0)).delete(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testDeleteMemberByUserIdConstraintIncorrect() throws Exception
    {
        // add to shared setUp
        doThrow(new ConstraintViolationException("", new HashSet<ConstraintViolation<?>>())).when(dialogDao).update
                (any(Dialog.class));
        chatWith3Members();
        anyUser();

        try
        {
            service.deleteMemberByUserId(1, 1);
        }
        finally
        {
            // Model
            verify(findedChatMock, times(1)).getMembersString();

            // Database
            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).delete(anyInt());
            verify(dialogDao, times(1)).update(any(Dialog.class));
            verify(usersDialogService, times(0)).delete(anyInt());
        }
    }

    @Test
    public void testDeleteMemberByUserIdCorrect() throws Exception
    {
        chatWith2Members();
        anyUser();
        // 2 chat members
        service.deleteMemberByUserId(1, 1);

        // Model
        verify(findedDialogMock, times(0)).getMembersString();

        // Database
        verify(dialogDao, times(1)).find(anyInt());
        verify(dialogDao, times(1)).delete(anyInt());
        verify(dialogDao, times(0)).update(any(Dialog.class));
        verify(usersDialogService, times(0)).delete(anyInt());
    }

    private void userNotExist()
    {
        when(usersService.find(anyInt())).thenReturn(null);
    }

    private void anyUser()
    {
        when(usersService.find(anyInt())).thenReturn(new Users());
    }

    private void chatNotFound()
    {
        when(dialogDao.find(anyInt())).thenReturn(null);
    }

    private void chatWith2Members()
    {
        findedDialogMock = mock(Dialog.class);
        List<UsersDialog> list = new ArrayList<UsersDialog>();
        list.add(new UsersDialog(1, 1));
        list.add(new UsersDialog(2, 1));
        when(findedDialogMock.getUsersdialogsesByDialogId()).thenReturn(list);
        when(findedDialogMock.getMembersString()).thenReturn("1,2");
        when(dialogDao.find(anyInt())).thenReturn(findedDialogMock);
    }

    private void chatWith3Members()
    {
        findedChatMock = mock(Dialog.class);
        when(findedChatMock.getMembersString()).thenReturn("1,2,3");
        List<UsersDialog> list = new ArrayList<UsersDialog>();
        list.add(new UsersDialog(1, 1));
        list.add(new UsersDialog(2, 1));
        list.add(new UsersDialog(3, 1));
        when(findedChatMock.getUsersdialogsesByDialogId()).thenReturn(list);
        when(dialogDao.find(anyInt())).thenReturn(findedChatMock);
    }
}