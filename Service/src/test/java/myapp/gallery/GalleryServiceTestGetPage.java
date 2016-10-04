package myapp.gallery;

import myapp.entities.Images;
import myapp.services.IGalleryDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class GalleryServiceTestGetPage {

    private GalleryService service;

    private IGalleryDao dao;

    private static final List<Images> LIST_AFTER_QUERY = Arrays.asList(new Images());
    private static final List<Images> LIST_EMPTY_RESULT_SET = new ArrayList<Images>();

    private static final int TABLE_COUNT = 50;
    private static final int PICTURES_COUNT_WITH_SAME_TAG = 20;

    @Test
    public void testGetFirstPageWithExistTag() throws Exception
    {

        List<Images> page = service.getPage(0, 1);

        verify(dao, times(0)).getPage(anyInt(), anyInt());
        verify(dao, times(0)).getTableCount();
        verify(dao, times(1)).getPicturesCountWithTag(anyInt());
        verify(dao, times(1)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_AFTER_QUERY, page);
    }

    @Test
    public void testGetSecondPageWithExistTag() throws Exception
    {

        List<Images> page = service.getPage(1, 1);

        verify(dao, times(0)).getPage(anyInt(), anyInt());
        verify(dao, times(0)).getTableCount();
        verify(dao, times(1)).getPicturesCountWithTag(anyInt());
        verify(dao, times(1)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_AFTER_QUERY, page);
    }

    @Test
    public void testGetOverflowPageWithExistTag() throws Exception
    {

        List<Images> page = service.getPage(2, 1);

        verify(dao, times(0)).getPage(anyInt(), anyInt());
        verify(dao, times(0)).getTableCount();
        verify(dao, times(1)).getPicturesCountWithTag(anyInt());
        verify(dao, times(0)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_EMPTY_RESULT_SET, page);
    }

    @Test
    public void testGetPageWithIncorrectTagId() throws Exception
    {

        List<Images> page = service.getPage(0, -1);

        verify(dao, times(0)).getPage(anyInt(), anyInt());
        verify(dao, times(0)).getTableCount();
        verify(dao, times(0)).getPicturesCountWithTag(anyInt());
        verify(dao, times(0)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_EMPTY_RESULT_SET, page);
    }

    @Test
    public void testGetPageOverflow() throws Exception
    {

        int pagesCount = (int) Math.ceil(((double) TABLE_COUNT) / GalleryService.PAGE_SIZE);

        int pageNumber = pagesCount + 1;

        List<Images> page = service.getPage(pageNumber, 0);

        verify(dao, times(0)).getPage(anyInt(), anyInt());
        verify(dao, times(1)).getTableCount();
        verify(dao, times(0)).getPicturesCountWithTag(anyInt());
        verify(dao, times(0)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_EMPTY_RESULT_SET, page);
    }

    @Test
    public void testGetFirstPage() throws Exception
    {
        int pageNumber = 0;

        List<Images> page = service.getPage(pageNumber, 0);

        verify(dao, times(1)).getPage(anyInt(), anyInt());
        verify(dao, times(1)).getTableCount();
        verify(dao, times(0)).getPicturesCountWithTag(anyInt());
        verify(dao, times(0)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_AFTER_QUERY, page);
    }

    @Test
    public void testGetPageNegative() throws Exception
    {
        int pageNumber = -2;

        List<Images> page = service.getPage(pageNumber, 0);

        verify(dao, times(0)).getPage(anyInt(), anyInt());
        verify(dao, times(0)).getTableCount();
        verify(dao, times(0)).getPicturesCountWithTag(anyInt());
        verify(dao, times(0)).getPageByTagId(anyInt(), anyInt(), anyInt());

        assertEquals(LIST_EMPTY_RESULT_SET, page);
    }

    @Before
    public void setUp() throws Exception
    {
        service = new GalleryService();

        dao = mock(IGalleryDao.class);
        when(dao.getPage(anyInt(), anyInt())).thenReturn(LIST_AFTER_QUERY);
        when(dao.getTableCount()).thenReturn(TABLE_COUNT);
        when(dao.getPageByTagId(anyInt(), anyInt(), anyInt())).thenReturn(LIST_AFTER_QUERY);
        when(dao.getPicturesCountWithTag(anyInt())).thenReturn(PICTURES_COUNT_WITH_SAME_TAG);
        ReflectionTestUtils.setField(service, "dao", dao);
    }
}