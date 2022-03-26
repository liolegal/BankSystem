import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.financesystem.Abstractions.BankAccount
import com.example.financesystem.R
import com.example.financesystem.Users.Client

class BankAccountsAdapter(private val context: Context,
                     private val dataSource: ArrayList<BankAccount>) : BaseAdapter() {

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
        val rowView = inflater.inflate(R.layout.list_item_accounts, parent, false)
// Get title element
        val idTitle = rowView.findViewById(R.id.id_of_account_title) as TextView

// Get subtitle element
        val moneyTitle = rowView.findViewById(R.id.money_title) as TextView
        val bankAccount = getItem(position) as BankAccount
        idTitle .text = bankAccount.idOfBankAccount
        moneyTitle.text = bankAccount.countOfMoney.toString()



        return rowView
    }

}
