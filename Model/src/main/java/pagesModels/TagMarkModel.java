package pagesModels;

public class TagMarkModel {

    private boolean isChecked;

    private String tagName;

    public TagMarkModel(boolean isChecked, String tagName)
    {
        this.isChecked = isChecked;
        this.tagName = tagName;
    }

    public TagMarkModel()
    {
    }

    public void setIsChecked(boolean isChecked)
    {
        this.isChecked = isChecked;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    public boolean getIsChecked()
    {
        return isChecked;
    }

    public String getTagName()
    {
        return tagName;
    }

}
