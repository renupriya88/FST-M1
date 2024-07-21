from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome()
driver.get("https://v1.training-support.net/selenium/selects")
print(driver.title)

	
# Store the select and create a new select object
multiselect = driver.find_element(By.ID, "multi-select")
dropdown_list = Select(multiselect)

# Get all options inside the select as a list
options = dropdown_list.options
#Get all the options and print them to the console.
for i in options:
    print(i.text)

print()
print()

#Select the "JavaScript" option using the visible text.
dropdown_list.select_by_visible_text("Javascript")
for i in dropdown_list.all_selected_options:
    print(i.text)

print()
print()

#Select the 4th, 5th and 6th options using the index.
dropdown_list.select_by_index(4)
dropdown_list.select_by_index(5)
dropdown_list.select_by_index(6)
for i in dropdown_list.all_selected_options:
    print(i.text)

print()
print()
#Select the "NodeJS" option using the value.
dropdown_list.select_by_value("node")
for i in dropdown_list.all_selected_options:
    print(i.text)

print()
print()
#Deselect the 5th option using index.
dropdown_list.deselect_by_index(5)
for i in dropdown_list.all_selected_options:
    print(i.text)

print()
print()
#Close the browser.
driver.close()