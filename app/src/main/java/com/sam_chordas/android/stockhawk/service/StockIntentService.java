package com.sam_chordas.android.stockhawk.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.gcm.TaskParams;

/**
 * Created by Rajesh Kumar Sharma on 12/18/16.
 */
public class StockIntentService extends IntentService {

  public StockIntentService(){
    super(StockIntentService.class.getName());
  }

  public StockIntentService(String name) {
    super(name);
  }

  @Override protected void onHandleIntent(Intent intent) {
    StockTaskService stockTaskService = new StockTaskService(this);
    Bundle args = new Bundle();
    if (intent.getStringExtra("tag").equals("add")){
      args.putString("symbol", intent.getStringExtra("symbol"));
    }
    // We can call OnRunTask from the intent service to force it to run immediately instead of
    // scheduling a task.
    stockTaskService.onRunTask(new TaskParams(intent.getStringExtra("tag"), args));
  }
}
