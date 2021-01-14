package com.yash.storeapp.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.storeapp.domain.Bill;
import com.yash.storeapp.domain.Customer;
import com.yash.storeapp.exceptions.BillIDException;
import com.yash.storeapp.service.BillService;
import com.yash.storeapp.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin
public class BillController {

	@Autowired
	private BillService billService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll() {
		List<Bill> bills = billService.getAllBills();
		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Bill bill, BindingResult result) throws BillIDException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Bill savedBill=billService.save(bill);
		return new ResponseEntity<Bill>(savedBill, HttpStatus.CREATED);
	}

	@GetMapping("/{billNumber}")
	public ResponseEntity<?> findByProjectIdentifier(@PathVariable String billNumber) throws BillIDException {
		Bill bill = billService.getBillByBillNumber(billNumber);
		return new ResponseEntity<Bill>(bill , HttpStatus.OK);
	}
}
