package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model;
 import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ArchiveModel {

        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("user_qayed_archive")
        @Expose
        private List<UserQayedArchive> userQayedArchive = null;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public List<UserQayedArchive> getUserQayedArchive() {
            return userQayedArchive;
        }

        public void setUserQayedArchive(List<UserQayedArchive> userQayedArchive) {
            this.userQayedArchive = userQayedArchive;
        }

    }

