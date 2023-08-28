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
private static final DataTableMetadata Organization_DEFINITION_METADATA;
private static final DataTableMetadata EDUCATIONAL_QUALIFICATIONS_DEFINATION_METADATA;

 

 

 

    
    static {

 

        ROLE_DEFINATION_METADATA=new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Role ID", "roleId","roleId" , ColumnType.TEXT, 31))
                .addColumnMetadata(new ColumnMetadata("Role Name", "roleName","roleName" , ColumnType.TEXT, 32))
                .addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,32));

 

        DESIGNATION_DEFINATION_METADATA=new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Designation ID", "designationId","designationId" , ColumnType.TEXT, 21))
                .addColumnMetadata(new ColumnMetadata("Designation Name", "designationName","designationName" , ColumnType.TEXT, 21))
                .addColumnMetadata(new ColumnMetadata("Designation Description","designationDesc","designationDesc",ColumnType.TEXT,32))
                .addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,21));

 

        GRADE_DEFINATION_METADATA=new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Grade ID", "gradeId","gradeId" , ColumnType.TEXT, 23))
                .addColumnMetadata(new ColumnMetadata("Grade Name", "gradeName","gradeName" , ColumnType.TEXT, 26))
                .addColumnMetadata(new ColumnMetadata("Grade Type","gradeType","gradeType",ColumnType.TEXT,23))
                .addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,23));

 

        EmployeeType_TYPE_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Employee Type ID", "employeeTypeId","employeeTypeId", ColumnType.TEXT, 31))
                .addColumnMetadata(new ColumnMetadata("Type", "type","type", ColumnType.TEXT, 32))
                .addColumnMetadata(new ColumnMetadata("Org Code", "orgCode","orgCode", ColumnType.TEXT, 32));

 

        Department_TYPE_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Department ID", "departmentId","departmentId", ColumnType.TEXT, 21))
                .addColumnMetadata(new ColumnMetadata("Department Name", "departmentName","departmentName", ColumnType.TEXT, 21))
                .addColumnMetadata(new ColumnMetadata("Department Description", "departmentDescription","departmentDescription", ColumnType.TEXT, 32))
                .addColumnMetadata(new ColumnMetadata("Org Code", "orgCode","orgCode", ColumnType.TEXT, 21));

 

        Division_TYPE_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Division ID", "divisionId","divisionId", ColumnType.TEXT, 21))
                .addColumnMetadata(new ColumnMetadata("Division Name", "divisionName","divisionName", ColumnType.TEXT, 21))
                .addColumnMetadata(new ColumnMetadata("Division Description", "divisionDescription","divisionDescription", ColumnType.TEXT, 32))
                .addColumnMetadata(new ColumnMetadata("Org Code", "orgCode","orgCode", ColumnType.TEXT, 21));

        Employee_Info_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Employee Code", "employeeCode","employeeCode", ColumnType.TEXT, 31))
                .addColumnMetadata(new ColumnMetadata("First Name", "firstName","firstName", ColumnType.TEXT, 32))
                .addColumnMetadata(new ColumnMetadata("Last Name", "lastName","lastName", ColumnType.TEXT, 32));

        Organization_DEFINITION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("Organization Code", "organizationCode","organizationCode", ColumnType.TEXT, 31))
                .addColumnMetadata(new ColumnMetadata("Organization Name", "organizationName","organizationName", ColumnType.TEXT, 32))
                .addColumnMetadata(new ColumnMetadata("Organization Description", "organizationDesc","organizationDesc", ColumnType.TEXT, 32));
        
        EDUCATIONAL_QUALIFICATIONS_DEFINATION_METADATA = new DataTableMetadata()
                .addColumnMetadata(new ColumnMetadata("", "id","id" ,ColumnType.RADIO, 05))
                .addColumnMetadata(new ColumnMetadata("SCHOOL/UNIVERSITY", "instituteName","instituteName" ,ColumnType.TEXT, 25))
                .addColumnMetadata(new ColumnMetadata("QUALIFICATION LEVEL", "qualificationLevel","qualificationLevel" ,ColumnType.TEXT, 25))
                .addColumnMetadata(new ColumnMetadata("EDUCATIONAL QUALIFICATION", "educationalQualification","educationalQualification" ,ColumnType.TEXT, 25))
               .addColumnMetadata(new ColumnMetadata("YEAR OF PASSING    ", "passingYear","passingYear" ,ColumnType.TEXT, 15));
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

    @GetMapping("organization")
    public DataTableMetadata getOrganizationDataTableMetadata() {
        return Organization_DEFINITION_METADATA;
    }

    @GetMapping("employee")
    public DataTableMetadata getEmployeeDataTableMetadata() {
        return Employee_Info_DEFINITION_METADATA;
    }
    
    @GetMapping("educational-qualification")
    public DataTableMetadata getEducationalQualificationMetadata() {
        return  EDUCATIONAL_QUALIFICATIONS_DEFINATION_METADATA;
    }
}