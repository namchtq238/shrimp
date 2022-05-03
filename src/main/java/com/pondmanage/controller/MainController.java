package com.pondmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * Home page controller
     *
     * @return
     */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    /**
     * Zone page controller
     *
     * @return
     */
    @GetMapping("/zones")
    public String zones() {
        return "zones/zones";
    }

    /**
     * Shrimp page controller
     *
     * @return
     */
    @GetMapping("/shrimps")
    public String shrimps() {
        return "shrimps/shrimps";
    }

    /**
     * Employees page controller
     *
     * @return
     */
    @GetMapping("/employees")
    public String employees() {
        return "employees/employees";
    }

    /**
     * Warehouse page controller
     *
     * @return
     */
    @GetMapping("/warehouse")
    public String warehouse() {
        return "warehouse/warehouse";
    }

    /**
     * Products page controller
     *
     * @return
     */
    @GetMapping("/products")
    public String products() {
        return "products/products";
    }

    /**
     * Statistics page controller
     *
     * @return
     */
    @GetMapping("/statistics")
    public String statistics() {
        return "statistics/statistics";
    }
}

