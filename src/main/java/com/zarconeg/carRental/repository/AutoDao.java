package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.Auto;
import org.springframework.stereotype.Repository;

@Repository("autoDao")
public class AutoDao extends AbstractDao<Long, Auto>{
}
