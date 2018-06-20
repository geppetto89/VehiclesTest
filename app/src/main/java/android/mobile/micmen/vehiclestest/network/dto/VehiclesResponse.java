
package android.mobile.micmen.vehiclestest.network.dto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class VehiclesResponse {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("currentPage")
    private Long mCurrentPage;
    @SerializedName("nextPage")
    private Long mNextPage;
    @SerializedName("totalPages")
    private Long mTotalPages;
    @SerializedName("vehicles")
    private List<Vehicle> mVehicles;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Long getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(Long currentPage) {
        mCurrentPage = currentPage;
    }

    public Long getNextPage() {
        return mNextPage;
    }

    public void setNextPage(Long nextPage) {
        mNextPage = nextPage;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public List<Vehicle> getVehicles() {
        return mVehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        mVehicles = vehicles;
    }

}
