from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome()
driver.get("https://v1.training-support.net/selenium/selects")
print(driver.title)

	
# Store the select and create a new select object
dropdown = driver.find_element(By.XPATH, '//*[@id="single-select"]')
dropdown_list = Select(dropdown)

# Get all options inside the select as a list
options = dropdown_list.options

# Select Element By Visible Text
dropdown_list.select_by_visible_text("Option 2")
print(dropdown_list.first_selected_option.text)


#Select the third option using the index.
dropdown_list.select_by_index(3)
print(dropdown_list.first_selected_option.text)


#Select the fourth option using the value.
dropdown_list.select_by_value("4")
print(dropdown_list.first_selected_option.text)

#Get all the options and print them to the console.
for i in options:
    print(i.text)

#Close the browser.
driver.close()


