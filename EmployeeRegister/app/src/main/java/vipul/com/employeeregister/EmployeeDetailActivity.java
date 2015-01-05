package vipul.com.employeeregister;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by vipulshah on 1/4/15.
 */
public class EmployeeDetailActivity extends
        ActionBarActivity implements View.OnClickListener {

    public static final String ACTION_ADD = "add";
    public static final String ACTION_EDIT = "edit";

    private EditText txtName ,txtLocation ,
    txtOrganisation;

    private Button btnSave , btnUpdate, btnDelete;

    private LinearLayout updateDeleteLayout;
    private EmployeeHelper employeeHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_details_layout);

        Bundle bundle = getIntent().getExtras();

        updateDeleteLayout = (LinearLayout)
                findViewById(R.id.layoutUpdateDelete);
        txtName = (EditText)findViewById(R.id.txtName);
        txtLocation = (EditText)findViewById(R.id.txtLocation);
        txtOrganisation = (EditText)findViewById(R.id.txtOrganisation);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        btnSave.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        if(bundle.getString("action").
                equals(ACTION_ADD))
        {
            updateDeleteLayout.setVisibility(View.GONE);
            btnSave.setVisibility(View.VISIBLE);
            setTitle("Add Employee");
        }
        else
        {
            btnSave.setVisibility(View.GONE);
            updateDeleteLayout.setVisibility(View.VISIBLE);
            setTitle("Edit Employee");
            txtName.setEnabled(false);


            txtName.setText(bundle.getString("name"));
            txtLocation.setText(bundle.getString("location"));
            txtOrganisation.setText(bundle.getString("organisation"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSave:
                addEmployee();
                break;
            case R.id.btnDelete:
                deleteEmployee(txtName.getText().toString());
                break;
            case R.id.btnUpdate:
                updateEmployee
                        (txtName.getText().toString(),
                         txtLocation.getText().toString(),
                         txtOrganisation.getText().toString());
        }
    }

    private void addEmployee()
    {
        employeeHelper = new
                EmployeeHelper(this);
        employeeHelper.open();

        String name = txtName.getText().
                toString();
        String location = txtLocation.getText().
                toString();
        String organisation = txtOrganisation.
                getText().
                toString();

        Employee employee = new Employee();
        employee.name = name;
        employee.location = location;
        employee.organisation = organisation;

        employeeHelper.addEmployee(employee);


        finish();
    }

    private void deleteEmployee(String name)

    {
        employeeHelper = new
                EmployeeHelper(this);
        employeeHelper.open();

        employeeHelper.deleteEmployee(name);

        employeeHelper.close();

        finish();
    }

    private void updateEmployee(String name,
                                String updatedLocation,
                                String updatedOrganisation)
    {
        employeeHelper = new
                EmployeeHelper(this);
        employeeHelper.open();

        employeeHelper.updateEmployee(name,updatedLocation,
                updatedOrganisation);

        employeeHelper.close();

        finish();
    }

}
