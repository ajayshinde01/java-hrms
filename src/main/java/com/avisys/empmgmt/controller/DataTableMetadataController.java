package com.avisys.empmgmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.empmgmt.dto.ColumnMetadata;
import com.avisys.empmgmt.dto.ColumnType;
import com.avisys.empmgmt.dto.DataTableMetadata;

@RestController
@RequestMapping("data-table-metadata")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DataTableMetadataController {
private static final DataTableMetadata ROLE_DEFINATION_METADATA;
private static final DataTableMetadata DESIGNATION_DEFINATION_METADATA;
private static final DataTableMetadata GRADE_DEFINATION_METADATA;
private static final DataTableMetadata EmployeeType_TYPE_DEFINITION_METADATA;
private static final DataTableMetadata Department_TYPE_DEFINITION_METADATA;
private static final DataTableMetadata Division_TYPE_DEFINITION_METADATA;
private static final DataTableMetadata Employee_Info_DEFINITION_METADATA;
 

 

    
    static {

        ROLE_DEFINATION_METADATA=new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 5))
                .addColumnMetadata(new ColumnMetadata("Role Id", "roleId","roleId" , ColumnType.TEXT, 10))
                .addColumnMetadata(new ColumnMetadata("Role name", "roleName","roleName" , ColumnType.TEXT, 10))
                .addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,5));

        DESIGNATION_DEFINATION_METADATA=new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 5))
                .addColumnMetadata(new ColumnMetadata("Designation Id", "designationId","designationId" , ColumnType.TEXT, 10))
                .addColumnMetadata(new ColumnMetadata("Designation Name", "designationName","designationName" , ColumnType.TEXT, 10))
                .addColumnMetadata(new ColumnMetadata("Designation Description","designationDesc","designationDesc",ColumnType.TEXT,10))
                .addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,5));

        GRADE_DEFINATION_METADATA=new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 5))
                .addColumnMetadata(new ColumnMetadata("Grade Id", "gradeId","gradeId" , ColumnType.TEXT, 10))
                .addColumnMetadata(new ColumnMetadata("Grade Name", "gradeName","gradeName" , ColumnType.TEXT, 10))
                .addColumnMetadata(new ColumnMetadata("Grade Type","gradeType","gradeType",ColumnType.TEXT,10))
                .addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,5));

        EmployeeType_TYPE_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 10))
                .addColumnMetadata(new ColumnMetadata("Employee Type Id", "employeeTypeId","employeeTypeId", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Type", "type","type", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Org Code", "orgCode","orgCode", ColumnType.TEXT, 30));

        Department_TYPE_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 10))
                .addColumnMetadata(new ColumnMetadata("Department Id", "departmentId","departmentId", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Department Name", "departmentName","departmentName", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Department Description", "departmentDescription","departmentDescription", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Org Code", "orgCode","orgCode", ColumnType.TEXT, 30));

        Division_TYPE_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 10))
                .addColumnMetadata(new ColumnMetadata("Division Id", "divisionId","divisionId", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Division Name", "divisionName","divisionName", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Division Description", "divisionDescription","divisionDescription", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Org Code", "orgCode","orgCode", ColumnType.TEXT, 30));
   
        Employee_Info_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 10))
                .addColumnMetadata(new ColumnMetadata("Employee Code", "employeeCode","employeeCode", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("First Name", "firstName","firstName", ColumnType.TEXT, 30))
                .addColumnMetadata(new ColumnMetadata("Last Name", "lastName","lastName", ColumnType.TEXT, 30));
    }



    @GetMapping("role")
    public DataTableMetadata getRoleDataTableMetadata() {
        return ROLE_DEFINATION_METADATA;
    }

    @GetMapping("grade")
    public DataTableMetadata getGradeDataTableMetadata() {
        return GRADE_DEFINATION_METADATA;
    }

    @GetMapping("designation")
    public DataTableMetadata getDesignationDataTableMetadata() {
        return DESIGNATION_DEFINATION_METADATA;
    }

    @GetMapping("employeeType-type")
    public DataTableMetadata getEmployeeTypeDataTableMetadata() {
        return EmployeeType_TYPE_DEFINITION_METADATA;
    }

    @GetMapping("department")
    public DataTableMetadata getDepartmentDataTableMetadata() {
        return Department_TYPE_DEFINITION_METADATA;
    }
 

    @GetMapping("division")
    public DataTableMetadata getDivisionDataTableMetadata() {
        return Division_TYPE_DEFINITION_METADATA;
    }
    
    @GetMapping("employee")
    public DataTableMetadata getEmployeeDataTableMetadata() {
        return Employee_Info_DEFINITION_METADATA;
    }
}