package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.Toast
import com.example.initiative.R

class MainActivity : AppCompatActivity() {

    // Request code for profile picture selection
    private val PICK_IMAGE = 100
    private lateinit var profileImageView: ImageView
    private lateinit var friendsCountTextView: TextView
    private lateinit var initiativesCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // Initialize views
        profileImageView = findViewById(R.id.profile_image)
        friendsCountTextView = findViewById(R.id.friends_count)
        initiativesCountTextView = findViewById(R.id.initiatives_count)

        // Initialize toolbar with dropdown menu
        val toolbar: Toolbar = findViewById(R.id.top_toolbar)
        setSupportActionBar(toolbar)

        // Handle profile picture click
        profileImageView.setOnClickListener {
            openGallery()
        }

        // Set up BottomNavigationView to navigate between activities
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navigateToHome()
                    true
                }
                R.id.nav_initiatives -> {
                    navigateToInitiatives()
                    true
                }
                R.id.nav_friends -> {
                    navigateToFriends()
                    true
                }
                else -> false
            }
        }

        // Fetch dynamic data (this is just a placeholder, you'd use a database)
        fetchDynamicData()
    }

    // Function to open the gallery for profile picture selection
    private fun openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(gallery, PICK_IMAGE)
    }

    // Handle result from gallery (i.e., the selected profile picture)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri: Uri? = data?.data
            imageUri?.let {
                profileImageView.setImageURI(it)
                // Save imageUri to local storage if needed
            }
        }
    }

    // Placeholder function for dynamic data (replace with real database fetch)
    private fun fetchDynamicData() {
        // Example data (replace with actual data from your database)
        val friendsCount = 45
        val initiativesCount = 13

        friendsCountTextView.text = "Friends: $friendsCount"
        initiativesCountTextView.text = "Initiatives: $initiativesCount"
    }

    // Function to navigate to Home activity
    private fun navigateToHome() {
        Toast.makeText(this, "Navigating to Home", Toast.LENGTH_SHORT).show()
    }

    // Function to navigate to Initiatives activity
    private fun navigateToInitiatives() {
        Toast.makeText(this, "Navigating to Initiatives", Toast.LENGTH_SHORT).show()
    }

    // Function to navigate to Friends activity
    private fun navigateToFriends() {
        Toast.makeText(this, "Navigating to Friends", Toast.LENGTH_SHORT).show()
    }

    // Handle toolbar menu (dropdown)
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.top_toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                navigateToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Function to navigate to Settings/Profile
    private fun navigateToSettings() {
        Toast.makeText(this, "Navigating to Settings", Toast.LENGTH_SHORT).show()
    }
}
