
import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@SuppressLint("ParcelCreator")
class VideoAdapter(
    private val listener: OnItemClickListener
) : ListAdapter<Video, VideoAdapter.VideoViewHolder>(DIFF_CALLBACK), Parcelable {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Video>() {
            override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean =
                oldItem == newItem
        }
    }

    interface OnItemClickListener {
        fun onItemClick(video: Video)
    }

    constructor(parcel: Parcel) : this(TODO("listener")) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item, parent, false)
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.textViewTitle.text = currentItem.title
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val video = getItem(position)
                listener.onItemClick(video)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VideoAdapter> {
        override fun createFromParcel(parcel: Parcel): VideoAdapter {
            return VideoAdapter(parcel)
        }

        override fun newArray(size: Int): Array<VideoAdapter?> {
            return arrayOfNulls(size)
        }
    }
}
