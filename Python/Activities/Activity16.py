class car:
    
# constrictor is created to define all the variables
    def __init__ (self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")
    
    def stop(self):
        print (self.manufacturer + " " + self.model + " has stopped")

obj1 = car("Hyundai", "i10", 2005, "petrol", "red")
obj2 = car("Toyota", "Innova", 2005, "petrol", "white")
obj3 = car("Kia", "Carnival", 2023, "petrol", "yelow")

obj1.accelerate()
obj2.stop()



