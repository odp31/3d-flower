from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np 

def petal(t, r, R):
  """
  Calculates x, y, z coordinates of a petal
  """
  x = (R + r * np.cos(5 * t)) * np.cos(t)
  y = (R + r * np.cos(5 * t)) * np.sin(t)
  z = r * np.sin(5 * t)
  return x, y, z

# parameters
num_petals = 5
r = 0.5
R = 1.5

# create figure and 3D axes
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# generate data for each petal
for i in range(num_petals):
  t = np.linspace(0, 2 * np.pi, 100) + 2 * np.pi * i / num_petals
  x, y, z = petal(t, r, R)
  ax.plot(x, y, z, color = 'red')

# customize plot
ax.set_xlabel('X')
ax.set_ylabel('Y')
ax.set_zlabel('Z')
ax.set_title('3d flower')
ax.view_init(elev=30, azim=45)

# show plot
plt.show()

