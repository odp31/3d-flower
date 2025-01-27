from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np

def petal(t, a, b):
    """
    Calculates the x, y, z coordinates of a petal.

    Args:
        t: Parameter for the curve, ranging from 0 to 2*pi.
        a: Scaling factor for the petal's width.
        b: Scaling factor for the petal's length.

    Returns:
        A tuple containing the x, y, and z coordinates of the petal point.
    """
    x = a * np.cos(t) * np.cos(2*t)
    y = a * np.sin(t) * np.cos(2*t)
    z = b * np.sin(2*t)
    return x, y, z

def create_flower(num_petals, a, b):
    """
    Creates 3D coordinates for a flower with the specified number of petals.

    Args:
        num_petals: The number of petals in the flower.
        a: Scaling factor for the petal's width.
        b: Scaling factor for the petal's length.

    Returns:
        Tuples containing x, y, and z coordinates for all petals.
    """
    t = np.linspace(0, 2*np.pi, 100)  # Adjust resolution as needed
    petals_coords = []
    for i in range(num_petals):
        angle = 2*np.pi*i/num_petals
        x, y, z = petal(t + angle, a, b)
        petals_coords.append((x, y, z))
    return petals_coords

# Parameters
num_petals = 5
a = 1.5
b = 2.0

# Create flower coordinates
flower_coords = create_flower(num_petals, a, b)

# Create 3D plot
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Plot petals
for x, y, z in flower_coords:
    ax.plot(x, y, z, color='red')

# Customize plot (optional)
ax.set_xlabel('X')
ax.set_ylabel('Y')
ax.set_zlabel('Z')
ax.set_title('3D Flower')
plt.show()
