from visual import *


groundheight = 1
initialheight = 2 + groundheight
initialvelocity = 15
angle = 45
height_of_goal = 8.25
distance_bewteen_robot_and_goal = 10

displaywindow = display(title = "Projectile Motion Simulation",
                        x = 0, y = 0, width = 1000, height = 1000,
                        range = 10, background= color.white,
                        center = (10, initialheight, 0))

shooting_platform = box(pos = (-1,initialheight-1,0), size = (5,1,4))
ball = sphere(pos = (0,initialheight,0), radius =0.5, color = color.yellow, make_trail  = true)


floor = box(pos=(0,groundheight,0), size = (100, 0.25,10))

rod = cylinder(pos=vector(10,height_of_goal,1),axis=vector(2,0,0), radius=1)



dt = 0.01

g = -9.81

gravity_vector = vector(0,g*dt,0)

ball_velocity = vector(initialvelocity*cos(angle*pi/180),
                        initialvelocity*sin(angle*pi/180),0)


        








while True:
    rate(40)
    ball_velocity = ball_velocity + gravity_vector
    ball.pos += ball_velocity*dt
    if ball.y < 2:
        break













