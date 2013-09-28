package com.discere.appxi.ui;

import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;

import com.discere.appxi.R;
import com.discere.appxi.model.TaxiStand;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

public class TaxiStandInfoWindow implements InfoWindowAdapter {

  private LayoutInflater mLayoutInflater;
  private Map<String, TaxiStand> mTaxiStandModel;

  public TaxiStandInfoWindow(LayoutInflater layoutInflater,
      Map<String, TaxiStand> taxiStandModel) {
    this.mLayoutInflater = layoutInflater;
    this.mTaxiStandModel = taxiStandModel;
  }

  @Override
  public View getInfoContents(Marker marker) {
    View infoWindow = mLayoutInflater.inflate(R.layout.taxi_stand_info_window, null);
    TaxiStand taxiStand = mTaxiStandModel.get(marker.getSnippet());
    return infoWindow;
  }

  @Override
  public View getInfoWindow(Marker marker) {
    return null;
  }

}
