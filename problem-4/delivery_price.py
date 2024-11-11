import math


class User:
    def __init__(self, type):
        self.type = type


def calculate_delivery_cost(origin, destination, package_weight, fragile, user):
    distance = calculate_distance(origin, destination)
    cost = calculate_base_cost(distance, package_weight, fragile)
    cost = membership_discount(cost, user)
    return cost


def calculate_distance(point_1, point_2):
    latitude_1, longitude_1, latitude_2, longitude_2 = map(
        math.radians, [point_1[0], point_1[1], point_2[0], point_2[1]]
    )
    delta_latitude = latitude_2 - latitude_1
    delta_longitude = longitude_2 - longitude_1

    haversine_term = (
        math.sin(delta_latitude / 2) ** 2
        + math.cos(latitude_1)
        * math.cos(latitude_2)
        * math.sin(delta_longitude / 2) ** 2
    )

    central_angle = 2 * math.atan2(
        math.sqrt(haversine_term), math.sqrt(1 - haversine_term)
    )

    EARTH_RADIUS = 6371.0

    distance = EARTH_RADIUS * central_angle

    return distance


def calculate_base_cost(discount, package_weight, fragile):
    if package_weight <= 5:
        cost = discount * 10
    else:
        cost = discount * 10 + (package_weight - 5) * 2

    if fragile:
        cost = cost * 1.5

    return cost


def membership_discount(cost, user):
    if user.type == "gold":
        cost = cost * 0.8
    elif user.type == "silver":
        cost = cost * 0.9
    return cost


def main():
    user = User("gold")
    origin = (4.602, -74.065)
    destination = (40.748, -73.986)
    package_weight = 30
    fragile = True
    delivery_cost = calculate_delivery_cost(
        origin, destination, package_weight, fragile, user
    )
    print(delivery_cost)


if __name__ == "__main__":
    main()
