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


	
	static {
		
		ROLE_DEFINATION_METADATA=new DataTableMetadata()
				.addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 5))
				.addColumnMetadata(new ColumnMetadata("Role Id", "roleId","roleId" , ColumnType.TEXT, 10))
				.addColumnMetadata(new ColumnMetadata("Role name", "roleName","roleName" , ColumnType.TEXT, 10))
				.addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,5));
		
		DESIGNATION_DEFINATION_METADATA=new DataTableMetadata()
				.addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 5))
				.addColumnMetadata(new ColumnMetadata("Designation Id", "designationId","roleId" , ColumnType.TEXT, 10))
				.addColumnMetadata(new ColumnMetadata("Designation Name", "designationName","roleName" , ColumnType.TEXT, 10))
				.addColumnMetadata(new ColumnMetadata("Designation Description","designationDesc","orgCode",ColumnType.TEXT,10))
				.addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,5));
		
		GRADE_DEFINATION_METADATA=new DataTableMetadata()
				.addColumnMetadata(new ColumnMetadata("", "id", "id", ColumnType.RADIO, 5))
				.addColumnMetadata(new ColumnMetadata("Grade Id", "gradeId","gradeId" , ColumnType.TEXT, 10))
				.addColumnMetadata(new ColumnMetadata("Grade Name", "gradeName","gradeName" , ColumnType.TEXT, 10))
				.addColumnMetadata(new ColumnMetadata("Grade Type","gradeTpe","gradeTpe",ColumnType.SELECT,10))
				.addColumnMetadata(new ColumnMetadata("Org Code","orgCode","orgCode",ColumnType.TEXT,5));
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
}
