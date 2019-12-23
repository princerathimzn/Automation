Feature:To Fill the form using data from feature file

  Scenario: To fill data using data table
    Given User is on form page
    When User enters details as following
      | First Name | Last Name | Sex  | Experience | Date       | Profession    | Profile Picture                                                    | Automation Tool | Continents | Continents – Multiple Select | Selenium Commands |
      | Prince     | Rathi     | Male | 6          | 17/12/2019 | Manual Tester | C:/Users/prince.rathi/Desktop/PHOTO/(ST_SD_19_154)_PRINCERATHI.JPG | QTP             | Africa     | Australia Antarctica         | Wait Commands     |
    Then The form is submitted