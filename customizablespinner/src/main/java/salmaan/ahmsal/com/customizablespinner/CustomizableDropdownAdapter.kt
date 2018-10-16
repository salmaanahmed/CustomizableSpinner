package salmaan.ahmsal.com.customizablespinner

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by salmaanahmed on 10/16/2017.
 * Custom adapter to customize dropdown and spinner view
 */
class CustomizableDropdownAdapter(context: Context,
                                  var objects: Array<String>,
                                  val dropDownView: (String) -> TextView,
                                  val selectedView: (String) -> TextView )
    : ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, objects) {

    // Request for customized view from the spinner
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return dropDownView(objects[position])
    }

    // Request for customized view from the spinner
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return selectedView(objects[position])
    }

    override fun getCount(): Int {
        return objects.count()
    }
}