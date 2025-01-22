import bpy

# clear default cube
bpy.ops.object.select_all(action='SELECT')
bpy.ops.object.delete(use_global=False)

# create new mesh
mesh = bpy.data.meshes.new("FlowerMesh")

# define vertices (ex: simple 4 petal flower)
vertices = [
  (0, 0, 0), 
  (1, 0, 0),
  (0.5, 0.866, 0),
  (-0.5, 0.866, 0),
  (-1, 0, 0),
]

# define faces (connecting vertices to form petals)
faces = [
  (0, 1, 2),
  (0, 2, 3),
  (0, 3, 4),
  (0, 4, 1),
]

# create
