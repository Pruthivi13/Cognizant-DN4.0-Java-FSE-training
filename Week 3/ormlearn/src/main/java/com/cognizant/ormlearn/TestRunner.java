package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.model.Product;
import com.cognizant.ormlearn.dto.ProductFilter;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TestRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRunner.class);

    private final CountryService countryService;
    private final StockRepository stockRepository;
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;
    private final ProductService productService;

    public TestRunner(CountryService countryService,
                      StockRepository stockRepository,
                      EmployeeRepository employeeRepository,
                      SkillRepository skillRepository,
                      ProductService productService) {
        this.countryService = countryService;
        this.stockRepository = stockRepository;
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Hands-on 1
        testSearchCountriesContaining();
        testSearchCountriesContainingSorted();
        testSearchCountriesStartingWith();

        // Hands-on 2
        testFacebookStockInSep2019();
        testGoogleStocksAbove1250();
        testTop3Volume();
        testLowestNetflix();

        // Hands-on 3
        testGetEmployee();
        testAddSkillToEmployee();

        // Hands-on 6 - Criteria Query
        testFilterAndPrintProducts();
    }

    // === Hands-on 6: Product Filtering with Criteria API ===
    private void testFilterAndPrintProducts() {
        LOGGER.info("Start - testFilterAndPrintProducts");

        ProductFilter filter = new ProductFilter();
        filter.setKeyword("laptop");
        filter.setRamSize(16);
        filter.setOperatingSystem("Windows");
        filter.setMinCpuSpeed(2.4);

        List<Product> products = productService.searchProducts(filter);

        System.out.println("Filtered Products:");
        products.forEach(p -> {
            System.out.println(" - " + p.getName());
            System.out.println("   OS: " + p.getOperatingSystem());
            System.out.println("   RAM: " + p.getRam());
            System.out.println("   CPU: " + p.getCpu());
            System.out.println("   Speed: " + p.getCpuSpeed() + " GHz");
        });

        LOGGER.info("End - testFilterAndPrintProducts");
    }

    // === Hands-on 1 Methods ===

    private void testSearchCountriesContaining() {
        LOGGER.info("Start - testSearchCountriesContaining");
        List<Country> countries = countryService.findByNameContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End - testSearchCountriesContaining");
    }

    private void testSearchCountriesContainingSorted() {
        LOGGER.info("Start - testSearchCountriesContainingSorted");
        List<Country> countries = countryService.findByNameContainingOrderByNameAsc("ou");
        LOGGER.debug("Sorted Countries containing 'ou': {}", countries);
        LOGGER.info("End - testSearchCountriesContainingSorted");
    }

    private void testSearchCountriesStartingWith() {
        LOGGER.info("Start - testSearchCountriesStartingWith");
        List<Country> countries = countryService.findByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End - testSearchCountriesStartingWith");
    }

    // === Hands-on 2 Methods ===

    private void testFacebookStockInSep2019() {
        LOGGER.info("Start - Facebook in Sep 2019");
        List<Stock> list = stockRepository.findByCodeAndDateBetween("FB",
                Date.valueOf("2019-09-01"),
                Date.valueOf("2019-09-30"));
        LOGGER.debug("Facebook Stocks in Sep 2019: {}", list);
        LOGGER.info("End");
    }

    private void testGoogleStocksAbove1250() {
        LOGGER.info("Start - Google > 1250");
        List<Stock> list = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250);
        LOGGER.debug("Google Stocks > 1250: {}", list);
        LOGGER.info("End");
    }

    private void testTop3Volume() {
        LOGGER.info("Start - Top 3 Volumes");
        List<Stock> list = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 by Volume: {}", list);
        LOGGER.info("End");
    }

    private void testLowestNetflix() {
        LOGGER.info("Start - Lowest Netflix");
        List<Stock> list = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest Netflix Prices: {}", list);
        LOGGER.info("End");
    }

    // === Hands-on 3 Methods ===

    private void testGetEmployee() {
        LOGGER.info("Start - testGetEmployee");

        Optional<Employee> optional = employeeRepository.findById(1);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            LOGGER.debug("Employee: {}", employee);
            LOGGER.debug("Department: {}", employee.getDepartment());
            LOGGER.debug("Skills: {}", employee.getSkillList());
        } else {
            LOGGER.warn("Employee with ID 1 not found.");
        }

        LOGGER.info("End - testGetEmployee");
    }

    private void testAddSkillToEmployee() {
        LOGGER.info("Start - testAddSkillToEmployee");

        Optional<Employee> optionalEmp = employeeRepository.findById(1);
        Optional<Skill> optionalSkill = skillRepository.findById(3); // change ID if needed

        if (optionalEmp.isPresent() && optionalSkill.isPresent()) {
            Employee employee = optionalEmp.get();
            Skill skill = optionalSkill.get();

            List<Skill> skillList = employee.getSkillList();
            if (!skillList.contains(skill)) {
                skillList.add(skill);
                employee.setSkillList(skillList);
                employeeRepository.save(employee);
                LOGGER.debug("Skill added to employee successfully.");
            } else {
                LOGGER.debug("Employee already has the skill.");
            }
        } else {
            LOGGER.warn("Employee or Skill not found.");
        }

        LOGGER.info("End - testAddSkillToEmployee");
    }
}
