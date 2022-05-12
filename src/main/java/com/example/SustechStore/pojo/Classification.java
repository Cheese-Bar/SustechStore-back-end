package com.example.SustechStore.pojo;

import java.io.Serializable;

/**
 * @author 
 * null
 */
public class Classification implements Serializable {
    private Integer classificationId;

    private String classificationName;

    private static final long serialVersionUID = 1L;

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Classification other = (Classification) that;
        return (this.getClassificationId() == null ? other.getClassificationId() == null : this.getClassificationId().equals(other.getClassificationId()))
            && (this.getClassificationName() == null ? other.getClassificationName() == null : this.getClassificationName().equals(other.getClassificationName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassificationId() == null) ? 0 : getClassificationId().hashCode());
        result = prime * result + ((getClassificationName() == null) ? 0 : getClassificationName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classificationId=").append(classificationId);
        sb.append(", classificationName=").append(classificationName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}