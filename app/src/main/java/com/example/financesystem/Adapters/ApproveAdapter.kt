import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.financesystem.R
import com.example.financesystem.Users.Client

class ApproveAdapter(private val context: Context,
                     private val dataSource: ArrayList<Client>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_approve, parent, false)
// Get title element
        val nameTitle = rowView.findViewById(R.id.name_title) as TextView

// Get subtitle element
        val secondNameTitle = rowView.findViewById(R.id.second_name_title) as TextView

// Get detail element
        val loginTitle = rowView.findViewById(R.id.login_title) as TextView

        val client = getItem(position) as Client
        nameTitle .text = client.name
        secondNameTitle.text = client.secondName
        loginTitle.text = client.login



        return rowView
    }

}
