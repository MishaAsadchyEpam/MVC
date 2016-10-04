package myapp.services;

import myapp.entities.Dialog;
import myapp.entities.Users;
import myapp.entities.UsersDialog;
import myapp.exceptions.EntityAlreadyExistException;
import myapp.exceptions.EntityNotFoundException;
import myapp.hibernateCRUDDao.DialogHibernateCRUDDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class DialogServiceTestAddMember {

    // real objects
    private DialogService service;

    // mockito
    private Dialog findedDialogMock;
    private DialogHibernateCRUDDao dialogDao;
    private UsersDialogService usersDialogService;
    private UsersService usersService;

    @Before
    public void setUp()
    {
        service = new DialogService();

        dialogDao = mock(DialogHibernateCRUDDao.class);
        usersDialogService = mock(UsersDialogService.class);
        usersService = mock(UsersService.class);

        ReflectionTestUtils.setField(service, "dialogDao", dialogDao);
        ReflectionTestUtils.setField(service, "usersDialogService", usersDialogService);
        ReflectionTestUtils.setField(service, "usersService", usersService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMemberAllIncorrect() throws Exception
    {
        try
        {
            service.addMember(-1, -1);
        }
        finally
        {
            // Database
            verify(usersService, times(0)).find(anyInt());
            verify(dialogDao, times(0)).find(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
            verify(usersDialogService, times(0)).save(any(UsersDialog.class));
        }
    }

    @Test(expected = EntityAlreadyExistException.class)
    public void testAddMemberAddExistUserToChat() throws Exception
    {
        // add to setup
        chatWith2Members();
        anyUser();

        try
        {
            service.addMember(1, 1);
        }
        finally
        {
            // Model
            verify(findedDialogMock, times(0)).getMembersString();
            verify(findedDialogMock, times(1)).getUsersdialogsesByDialogId();

            // Database
            verify(usersService, times(1)).find(anyInt());
            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
            verify(usersDialogService, times(0)).save(any(UsersDialog.class));
        }
    }

    @Test(expected = EntityNotFoundException.class)
    public void testAddMemberChatNotExist() throws Exception
    {
        // add to setup
        chatNotFound();
        anyUser();

        try
        {
            service.addMember(1, 4);
        }
        finally
        {
            // Database
            verify(usersService, times(0)).find(anyInt());
            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
            verify(usersDialogService, times(0)).save(any(UsersDialog.class));
        }
    }

    @Test(expected = EntityNotFoundException.class)
    public void testAddMemberUserNotExist() throws Exception
    {
        // add to setup
        chatWith2Members();
        userNotExist();

        try
        {
            service.addMember(1, 4);
        }
        finally
        {
            // Model
            verify(findedDialogMock, times(0)).getMembersString();
            verify(findedDialogMock, times(0)).getUsersdialogsesByDialogId();

            // Database
            verify(usersService, times(1)).find(anyInt());
            verify(dialogDao, times(1)).find(anyInt());
            verify(dialogDao, times(0)).update(any(Dialog.class));
            verify(usersDialogService, times(0)).save(any(UsersDialog.class));
        }
    }

    @Test
    public void testAddMemberCorrect() throws Exception
    {
        // add to setup
        chatWith2Members();
        anyUser();

        service.addMember(1, 4);

        // Model
        verify(findedDialogMock, times(0)).getMembersString();
        verify(findedDialogMock, times(1)).getUsersdialogsesByDialogId();

        // Database
        verify(usersService, times(1)).find(anyInt());
        verify(dialogDao, times(1)).find(anyInt());
        verify(dialogDao, times(1)).update(any(Dialog.class));
        verify(usersDialogService, times(1)).save(any(UsersDialog.class));
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

}