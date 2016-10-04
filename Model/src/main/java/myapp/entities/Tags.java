package myapp.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Tags {
    private int tagId;
    private String tagName;
    private Collection<Picturetags> picturetagsesByTagId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "tagId")
    public int getTagId()
    {
        return tagId;
    }

    public void setTagId(int tagId)
    {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "tagName")
    @NotNull
    @NotEmpty
    @Size(max = 50)
    public String getTagName()
    {
        return tagName;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (tagId != tags.tagId) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return tagId;
    }

    @OneToMany(mappedBy = "tagsByTagId")
    public Collection<Picturetags> getPicturetagsesByTagId()
    {
        return picturetagsesByTagId;
    }

    public void setPicturetagsesByTagId(Collection<Picturetags> picturetagsesByTagId)
    {
        this.picturetagsesByTagId = picturetagsesByTagId;
    }
}
