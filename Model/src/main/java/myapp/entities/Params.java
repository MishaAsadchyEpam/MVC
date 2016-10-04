package myapp.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
class Params {
    private String paramName;
    private String paramValue;
    private int paramId;

    @Basic
    @Column(name = "paramName")
    public String getParamName()
    {
        return paramName;
    }

    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }

    @Basic
    @Column(name = "paramValue")
    public String getParamValue()
    {
        return paramValue;
    }

    public void setParamValue(String paramValue)
    {
        this.paramValue = paramValue;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "paramId")
    public int getParamId()
    {
        return paramId;
    }

    public void setParamId(int paramId)
    {
        this.paramId = paramId;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Params params = (Params) o;

        if (paramName != null ? !paramName.equals(params.paramName) : params.paramName != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return paramName != null ? paramName.hashCode() : 0;
    }
}
