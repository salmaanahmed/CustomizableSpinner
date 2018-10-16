package salmaan.ahmsal.com.customizablespinner

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.AppCompatSpinner
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.TextView

/**
 * Created by salmaanahmed on 10/16/2017.
 * Customizable spinner for easy data binding, listening and xml customization
 */
class CustomizableSpinner : AppCompatSpinner {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        attrs.let {
            typedArray = context.obtainStyledAttributes(it, R.styleable.CustomizableSpinner, 0, 0)
        }
    }

    // Local variables
    private var selectionChanged: ((Int, String) -> Unit)? = null
    private var typedArray: TypedArray? = null

    // Custom adapter initialized with empty array
    private val dataAdapter = CustomizableDropdownAdapter(context, arrayOf(), dropDownView =  {
        return@CustomizableDropdownAdapter getDropDownView(it)
    }, selectedView = {
        return@CustomizableDropdownAdapter getSelectedView(it)
    })

    // update array whenever new dataset is assigned
    var dataSet = arrayOf<String>()
        set(value) {
            dataAdapter.objects = value
            dataAdapter.notifyDataSetChanged()
            field = value
        }

    // Set adapter and listener on initialization
    init {
        this.adapter = dataAdapter
        this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) { }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectionChanged?.invoke(position, dataSet[position])
            }
        }
    }

    /**
     * Customize view from attributes provided in xml
     */
    private fun getSelectedView(text: String): TextView {
        val textView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_item,null) as TextView
        textView.text = text

        for (i in 0..typedArray?.indexCount!!) {
            val attr = typedArray?.getIndex(i)
            when (attr) {
                R.styleable.CustomizableSpinner_selectedTextColor ->
                    textView.setTextColor(typedArray?.getColor(attr, 0)!!)

                R.styleable.CustomizableSpinner_selectedBackgroundColor ->
                    textView.setBackgroundColor(typedArray?.getColor(attr, 0)!!)

                R.styleable.CustomizableSpinner_selectedTextSize ->
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray?.getDimensionPixelSize(attr, 0)!!.toFloat())

                R.styleable.CustomizableSpinner_selectedMaxLines ->
                    textView.maxLines = typedArray?.getInt(attr, 1)!!

                R.styleable.CustomizableSpinner_selectedHeight ->
                    textView.height = typedArray?.getDimensionPixelOffset(attr, 1)!!

                R.styleable.CustomizableSpinner_selectedPadding -> {
                    val padding = typedArray?.getDimensionPixelOffset(attr, 1)!!
                    textView.setPadding(padding, padding, padding, padding)
                }
            }
        }
        return textView
    }

    /**
     * Customize dropdown view from attributes provided in xml
     */
    private fun getDropDownView(text: String): TextView {
        val textView = LayoutInflater.from(context).inflate(android.R.layout.simple_spinner_dropdown_item,null) as TextView
        textView.text = text

        for (i in 0..typedArray?.indexCount!!) {
            val attr = typedArray?.getIndex(i)
            when (attr) {
                R.styleable.CustomizableSpinner_dropDownTextColor ->
                    textView.setTextColor(typedArray?.getColor(attr, 0)!!)

                R.styleable.CustomizableSpinner_dropDownBackgroundColor ->
                    textView.setBackgroundColor(typedArray?.getColor(attr, 0)!!)

                R.styleable.CustomizableSpinner_dropDownTextSize ->
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray?.getDimensionPixelSize(attr, 0)!!.toFloat())

                R.styleable.CustomizableSpinner_dropDownMaxLines ->
                    textView.maxLines = typedArray?.getInt(attr, 1)!!

                R.styleable.CustomizableSpinner_dropDownHeight ->
                    textView.height = typedArray?.getDimensionPixelOffset(attr, 1)!!

                R.styleable.CustomizableSpinner_dropDownPadding -> {
                    val padding = typedArray?.getDimensionPixelOffset(attr, 1)!!
                    textView.setPadding(padding, padding, padding, padding)
                }
            }
        }
        return textView
    }

    /**
     * Setup selection changed callback
     */
    fun selectionChanged(selectionChanged: ((Int, String) -> Unit)?) {
        this.selectionChanged = selectionChanged
    }

    /**
     * Set selected value
     */
    fun setSelectedValue(value: String, animate: Boolean = false) {
        if (dataSet.contains(value)) this.setSelection(dataSet.indexOf(value), animate)
    }
}