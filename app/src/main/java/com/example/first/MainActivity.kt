// MainActivity.kt

import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), VideoAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        videoAdapter = VideoAdapter(this, this)
        recyclerView.adapter = videoAdapter

        // Mock data (replace with actual data)
        val videoList = listOf(
            Video("2 Slogger", "https://youtu.be/oKBm2xkCqO0?feature=shared"),
            Video("Philosopher.", "https://youtu.be/l7IMiHAJumo?feature=shared"),
            Video("Manchester United", "https://youtu.be/wu8qwKiqpKk?feature=shared")
        )

        videoAdapter.submitList(videoList)
    }

    override fun onItemClick(video: MediaStore.Video) {
        // Handle item click (e.g., open video player)
        Toast.makeText(this, "Clicked: ${video.title}", Toast.LENGTH_SHORT).show()
        // You can navigate to a video player activity here
    }
}
