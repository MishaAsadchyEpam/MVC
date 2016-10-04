package pagesModels;

import java.util.List;

public class EditTagsModel {

    private List<TagMarkModel> tagMarkModels;

    private int imageId;

    public EditTagsModel()
    {
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }

    public void setTagMarkModels(List<TagMarkModel> tagMarkModels)
    {
        this.tagMarkModels = tagMarkModels;
    }

    public EditTagsModel(List<TagMarkModel> tagMarkModels, int imageId)
    {
        this.tagMarkModels = tagMarkModels;
        this.imageId = imageId;
    }

    public int getImageId()
    {
        return imageId;
    }

    public List<TagMarkModel> getTagMarkModels()
    {
        return tagMarkModels;
    }

}
