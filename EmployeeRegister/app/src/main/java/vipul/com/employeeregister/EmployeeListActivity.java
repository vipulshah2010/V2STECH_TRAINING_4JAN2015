package vipul.com.employeeregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListActivity
        extends ActionBarActivity implements
        View.OnClickListener,
        AdapterView.OnItemClickListener{

    private Button btnAddEmployee;
    private ListView listEmployeeNames;
    private TextView txtNoRecords;
    private EmployeeHelper employeeHelper;
    private ArrayAdapter<String> employeeNames;
    private List<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_list_layout);

        setTitle("Employees");

        employees = new ArrayList<>();

        employeeNames = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        btnAddEmployee = (Button)
                findViewById(R.id.btnAddEmployee);

        btnAddEmployee.setOnClickListener(this);

        txtNoRecords = (TextView)
                findViewById(R.id.txtNoRecords);
        listEmployeeNames = (ListView)
                findViewById(R.id.listEmployeeNames);
        listEmployeeNames.setAdapter(employeeNames);
    }

    @Override
    protected void onStart() {
        super.onStart();

        employeeNames.clear();
        employees.clear();

        employeeHelper = new
                EmployeeHelper(this);

        employeeHelper.open();

        employees =
                employeeHelper.getEmployees();

        employeeHelper.close();

        if(employees.size()==0)
        {
            listEmployeeNames.
                    setVisibility(View.GONE);
            txtNoRecords.setVisibility(View.VISIBLE);
        }
        else
        {
            listEmployeeNames.
                    setVisibility(View.VISIBLE);
            txtNoRecords.setVisibility(View.GONE);

            for(Employee employee : employees)
            {
                employeeNames.add(employee.name);
            }

            employeeNames.notifyDataSetChanged();

        }

        listEmployeeNames.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,
                EmployeeDetailActivity.class);
        intent.putExtra("action",
                EmployeeDetailActivity.ACTION_ADD);
        startActivity(intent);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Employee employee =  employees.get(position);

        Intent intent = new Intent(this,
                EmployeeDetailActivity.class);
        intent.putExtra("action",
                EmployeeDetailActivity.ACTION_EDIT);
        intent.putExtra("name",employee.name);
        intent.putExtra("location",employee.location);
        intent.putExtra("organisation",employee.organisation);
        startActivity(intent);

    }
}
