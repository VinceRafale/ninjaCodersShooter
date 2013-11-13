package com.example.tehshootie;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.project.game.FirstActivity;
import com.swarmconnect.Swarm;
import com.swarmconnect.SwarmActivity;

public class MainActivity extends SwarmActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user clicks the arcade button */
	public void startArcade(View view) {
		Intent intent = new Intent(this, FirstActivity.class);
		startActivity(intent);
	}
	
	/** Called when the user clicks the score button */
	public void getLeaderboard(View view) {
		Swarm.showLeaderboards();
	}
	
	/** Called when the user clicks the social button */
	public void login(View view) {
		// Allow guest accounts
		// Call before calling Swarm.init(...)
		Swarm.setAllowGuests(true);
		Swarm.init(this, 8468, "9cb6a991a386fb6a46959558ed062519");
	}
}
