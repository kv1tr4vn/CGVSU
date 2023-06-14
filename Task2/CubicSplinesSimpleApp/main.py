import matplotlib.pyplot as plt
from cubic_spline_2d import *


def calculate_2d_spline_interpolation(x, y, num=100):
    cubic_spline_2d = CubicSpline2D(x, y)
    params = np.linspace(cubic_spline_2d.params[0], cubic_spline_2d.params[-1], num)[:-1]

    result_x, result_y = [], []
    for param in params:
        point_x, point_y = cubic_spline_2d.point(param)
        result_x.append(point_x)
        result_y.append(point_y)

    return result_x, result_y


if __name__ == '__main__':
    x_points = []
    y_points = []
    fig, ax = plt.subplots(figsize=(9, 9), num="Cubic Splines Simple App")

    curve, = ax.plot(x_points, y_points, "-g", label="spline")
    points, = ax.plot(x_points, y_points, "x")

    def on_click(event):
        x_new_point, y_new_point = ax.transData.inverted().transform([event.x, event.y])

        x_points.append(x_new_point)
        y_points.append(y_new_point)

        if len(x_points) > 1 and len(x_points) == len(y_points):
            x_curve_points, y_curve_points = calculate_2d_spline_interpolation(x_points, y_points, num=500)
            curve.set_xdata(x_curve_points)
            curve.set_ydata(y_curve_points)

        points.set_xdata(x_points)
        points.set_ydata(y_points)

        fig.canvas.draw()

    fig.canvas.mpl_connect('button_press_event', on_click)
    plt.show()
