import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a11_nlivedata.databinding.FragmentAddNoteBinding
import com.example.a11_nlivedata.room.RoomActivity
import com.example.a11_nlivedata.room.db.Note


class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteBinding
    private lateinit var note: Note

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            fabSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDescription.text.toString()
                note = Note(0,title,desc)
                //دسترسی به Activity
                (activity as RoomActivity).noteDb.noteDao().saveNote(note)

                //بستن فرگمنت فعلی و رفتن به فرگمنت قبلی
                findNavController().popBackStack()
            }
        }
    }


}