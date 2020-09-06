package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter;

import android.util.Log;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public  abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    private static final String TAG = PaginationScrollListener.class.getSimpleName();
    private LinearLayoutManager layoutManager;
    private  static int ROW_COUNT =18;
    private  static int P_START =0;
    private  static int P_LENGTH =10;
    private int currentPage=0;
    private boolean isLoading=false;

    public PaginationScrollListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }//end constructor

    /*
     Method gets callback when user scroll the search list
     */
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        if (!isLoading() && !isLastPage()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                    Log.i(TAG, "Loading more items");
                    loadMoreItems();
            }//end if
        }//end if

    }//end onScrolled

    public abstract void loadMoreItems();

    public  int getTotalPageCount(){
            return ROW_COUNT / P_LENGTH ;
    }//end getTotalPageCount

    public  boolean isLastPage(){
    return currentPage==getTotalPageCount();
    }//end isLastPage


    public  boolean isLoading(){
        return isLoading ;
    }//private isLoading
    public static void setRowCount(String rowCount) {
        PaginationScrollListener.ROW_COUNT = Integer.parseInt(rowCount);
    } //end set rowCount

    public static int getPStart() {
        return P_START;
    }//end getPageStart

    public static int getPLength() {
        return P_LENGTH;
    }///end getPageLength


    public void incCurrentPage() {
         currentPage++;
    }//end incCurrentPage

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public int getFirstItem(){
      int index= P_LENGTH*currentPage + P_START;
      return  index ;
    }//end getFirstItem

    public int getLastItem(){
        int index;
        if(isLastPage()){
            index = ROW_COUNT ;
        }
      index = currentPage*(P_LENGTH +1);
        return  index ;
    }//end getLastItem
}//end class