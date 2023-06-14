from cubic_spline import *


class CubicSpline2D:
    def __init__(self, x, y):
        self.params = self.__calculate_params(x, y)
        self.sx = CubicSpline(self.params, x)
        self.sy = CubicSpline(self.params, y)

    def point(self, param):
        x = self.sx.point(param)
        y = self.sy.point(param)
        return x, y

    def __calculate_params(self, x, y):
        dx = np.diff(x)
        dy = np.diff(y)
        self.ds = [np.sqrt(idx ** 2 + idy ** 2) for (idx, idy) in zip(dx, dy)]
        s = [0.0]
        s.extend(np.cumsum(self.ds))
        return s
