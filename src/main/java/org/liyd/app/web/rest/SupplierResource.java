package org.liyd.app.web.rest;

import com.google.common.base.Objects;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.liyd.app.service.SupplierService;
import org.liyd.app.service.dto.SupplierDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource/supplier")
public class SupplierResource {

  private SupplierService supplierService;

  public SupplierResource(SupplierService supplierService) {
    this.supplierService = supplierService;
  }


  @PostMapping("/save")
  public SupplierDTO insert(@RequestBody SupplierDTO supplierDTO) {
    return supplierDTO;
  }

  @ApiOperation(value = "Find pet by Status",
          notes = "${SomeController.findPetsByStatus.notes}")
  @GetMapping("/select")
  public SupplierDTO select(){

    return null;
  }

}
