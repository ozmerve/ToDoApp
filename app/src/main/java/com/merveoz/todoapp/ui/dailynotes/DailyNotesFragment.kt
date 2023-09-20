package com.merveoz.todoapp.ui.dailynotes


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.merveoz.todoapp.R
import com.merveoz.todoapp.common.viewBinding
import com.merveoz.todoapp.data.model.Note
import com.merveoz.todoapp.data.source.Database
import com.merveoz.todoapp.databinding.DialogAddNoteBinding
import com.merveoz.todoapp.databinding.FragmentDailyNotesBinding


class DailyNotesFragment : Fragment(R.layout.fragment_daily_notes) {

    private val binding by viewBinding(FragmentDailyNotesBinding::bind)

    private val dailyNotesAdapter = DailyNotesAdapter(
        onNoteClick = ::onNoteClick,
        onDeleteClick = ::onDeleteNote) //sayfa açıldığı anda adapter oluşacak

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvDailyNotes.adapter = dailyNotesAdapter
            dailyNotesAdapter.updateList(Database.getDailyNotes()) //database olduğu için nesne oluşturmadan kullanılır

            fabAdd.setOnClickListener {
                showAddDialog()
            }
        }
    }

    private fun onNoteClick(desc: String){
        Toast.makeText(requireContext(), desc, Toast.LENGTH_SHORT).show()
    }

    private fun onDeleteNote(note: Note){
        //Note silme
        Database.removeDailyNoteById(note.id)
        dailyNotesAdapter.updateList(Database.getDailyNotes())
    }


    private fun showAddDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val dialogBinding = DialogAddNoteBinding.inflate(layoutInflater) //initialize
        builder.setView(dialogBinding.root)
        val dialog = builder.create()

        with(dialogBinding){

            btnAddNote.setOnClickListener {

                val title = etTitle.text.toString()
                val desc = etDesc.text.toString()
                var priorityColorId = R.color.default_priority_color

                //Öncelik rengini belirleme
                if (rbHigh.isChecked){
                    priorityColorId = R.color.highPriorityColor
                } else if (rbMedium.isChecked){
                    priorityColorId = R.color.mediumPriorityColor
                } else if (rbLow.isChecked){
                    priorityColorId = R.color.lowPriorityColor
                }


                if(title.isNotEmpty() && desc.isNotEmpty()){
                    Database.addDailyNote(title, desc, priorityColorId)
                    dailyNotesAdapter.updateList((Database.getDailyNotes()))
                    dialog.dismiss()
                } else {
                    Toast.makeText(requireContext(), "Please fill in the blanks!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        dialog.show()
    }
}