#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

// define a 3d point structure 
struct Point3D {
  double x, y, z;
};

// function to calculate distance between 2 3d points 
double distance(const Point3D& p1, const Point3D& p2)
{
  return std::sqrt(std::pow(p1.x - p2.x, 2) + std::pow(p1.y - p2.y, 2) + std::pow(p1.z - p2.z, 2));
}

// flower class 
class Flower3D {
private:
  Point3D center;
  double radius;
  int numPetals;
  std::vector<Point3D> petals;

public:
  // constructor 
  Flower3D(const Point3D& center, double radius, int numPetals) :
    center(center), radius(radius), numPetals(numPetals) {
      generatePetals();
  }

  // generate petal points
  void generatePetals() {
    petals.clear();

    for(int i = 0; i < numPetals; ++i) {
      double angle = (2 * M_PI * i) / numPetals;
      double petalRadius = radius * 1.5;

      Point3D petal;
      petal.x = center.x + petalRadius * std::cos(angle);
      petal.y = center.y + petalRadius * std::sin(angle);
      petal.z = center.z + radius * 0.5 * std::cos(angle * 3);

      petals.push_back(petal);
      int stemPoints = 5; 
      for(int j = 1; j <= stemPoints; ++j) {
        Point3D stemPoint;
        stemPoint.x = center.x;
        stemPoint.y = center.y;
        stemPoint.z = center.z - radius * j/stemPoints;
        petals.push_back(stemPoint);
      }
    }
  }
// get petals (for rendering or other processing)
const std::vector<Point3D>& getPetals() const {
  return petals;
}

// print petal coordinates 
void printPetalCoordinates() const {
  std::cout << "flower center: (" << center.x << ", " << center.y << ", " << center.z << ")" << std::endl;
  std::cout << "Petals:" << std::endl;
  for(const auto& petal: petals) {
    std::cout << "(" << petal.x << ", " << petal,y << ", " << petal.z << ")" << std::endl;
  }
}

// get center
Point3D getCenter() const {
  return center;
}

double getRadius() const {
  return radius;
}

int getNumPetals() const {
  return numPetals;
}
};

int main() {
  Point3D flowerCenter = {0, 0, 0};
  Flower3D myFlower(flowerCenter, 5, 8);
  myFlower.printPetalCoordinates();

  const std::vector<Point3D>& petals = myFlower.getPetals();
  return 0;
}
