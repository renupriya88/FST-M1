game = 0
w = "Yes"
while game == 0 and str(w) == "Yes":
    rounds = input("How many rounds do we play")
    if rounds == 0:
        print("Thank you, See you")
        raise SystemExit
    else:
        a = 1
        x = 0
        y = 0
        while (a < int(rounds)):
            user1 = input("Say Rock Paper Scissor")
            user2 = input("Say Rock Paper Scissor")

            if user1 == "rock" and user2 == "scissor":
                print("user1 beats user2")
                x += 1
            elif user1 == "scissor" and user2 == "paper":
                print("user1 beats user2")
                x += 1
            elif user1 == "paper" and user2 == "rock":
                print("user1 beats user2")
                x += 1
            elif user2 == "paper" and user1 == "rock":
                print("user2 beats user1")
                y += 1
            elif user2 == "scissor" and user1 == "paper":
                print("user2 beats user1")
                y += 1
            elif user2 == "rock" and user1 == "scissor":
                print("user2 beats user1")
                y += 1
    
            a += 1

        print(x)
        print(y)
        if x < y:
            print (f"USER2 won by {y} points.")
        elif x > y :
            print (f"USER1 won by {x} points.")
        elif x == y :
            print (f"ITS A TIE User 1 has {x} points and User2 has {y} points.")

        w = input("Do you want to play another game?")

else:
    print("Thank you for Playing, Bye")



