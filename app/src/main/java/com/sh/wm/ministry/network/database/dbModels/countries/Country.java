
package com.sh.wm.ministry.network.database.dbModels.countries;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "countries_table")
public class Country {

    @SerializedName("CD_TB_CD")
    @Expose
    private String cDTBCD;
    @PrimaryKey
    @NonNull
    @SerializedName("CD_CD")
    @Expose
    private String cDCD;
    @SerializedName("CD_ARB_TR")
    @Expose
    private String cDARBTR;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("CD_CD_NEW")
    @Expose
    private String cDCDNEW;
    @SerializedName("CD_ENG_TR")
    @Expose
    private String cDENGTR;

    public String getCDTBCD() {
        return cDTBCD;
    }

    public void setCDTBCD(String cDTBCD) {
        this.cDTBCD = cDTBCD;
    }

    public String getCDCD() {
        return cDCD;
    }

    public void setCDCD(String cDCD) {
        this.cDCD = cDCD;
    }

    public String getCDARBTR() {
        return cDARBTR;
    }

    public void setCDARBTR(String cDARBTR) {
        this.cDARBTR = cDARBTR;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getCDCDNEW() {
        return cDCDNEW;
    }

    public void setCDCDNEW(String cDCDNEW) {
        this.cDCDNEW = cDCDNEW;
    }

    public String getCDENGTR() {
        return cDENGTR;
    }

    public void setCDENGTR(String cDENGTR) {
        this.cDENGTR = cDENGTR;
    }

}
