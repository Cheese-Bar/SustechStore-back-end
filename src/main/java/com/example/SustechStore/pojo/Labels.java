package com.example.SustechStore.pojo;

import java.io.Serializable;

/**
 * @author 
 * null
 */
public class Labels implements Serializable {
    private Integer labelsId;

    private String labelsName;

    private static final long serialVersionUID = 1L;

    public Integer getLabelsId() {
        return labelsId;
    }

    public void setLabelsId(Integer labelsId) {
        this.labelsId = labelsId;
    }

    public String getLabelsName() {
        return labelsName;
    }

    public void setLabelsName(String labelsName) {
        this.labelsName = labelsName;
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
        Labels other = (Labels) that;
        return (this.getLabelsId() == null ? other.getLabelsId() == null : this.getLabelsId().equals(other.getLabelsId()))
            && (this.getLabelsName() == null ? other.getLabelsName() == null : this.getLabelsName().equals(other.getLabelsName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLabelsId() == null) ? 0 : getLabelsId().hashCode());
        result = prime * result + ((getLabelsName() == null) ? 0 : getLabelsName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", labelsId=").append(labelsId);
        sb.append(", labelsName=").append(labelsName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}