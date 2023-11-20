import numpy as np
import matplotlib.pyplot as plt


def linear_function(k, b, x):
    return k * x + b


def gradient(x_points, y_points, k, b):
    n_points = len(x_points)
    assert n_points == len(y_points)

    dk = 2 / n_points * sum([(k * x_points[point_ind] + b - y_points[point_ind]) * x_points[point_ind]
                             for point_ind in range(n_points)])
    db = 2 / n_points * sum([(k * x_points[point_ind] + b - y_points[point_ind])
                            for point_ind in range(n_points)])

    return np.array([dk, db])


def gradient_descent(x_points, y_points, k_init, b_init, step, n_max_iters, eps):
    k = k_init
    b = b_init

    iter_ind = 0
    while np.linalg.norm(gradient(x_points, y_points, k, b)) > eps and iter_ind < n_max_iters:
        grad = gradient(x_points, y_points, k, b)
        k = k - step * grad[0]
        b = b - step * grad[1]
        iter_ind = iter_ind + 1
        # print("iter: {} grad: {}".format(iter_ind, np.linalg.norm(grad)))

    return k, b


if __name__ == '__main__':
    plot_radius = 5

    fig, ax = plt.subplots(figsize=(9, 9), num="Linear Regression Simple App")
    ax.set_xlim([-plot_radius, plot_radius])
    ax.set_ylim([-plot_radius, plot_radius])

    eps = 1e-4
    step = 1e-2
    n_max_iters = 100

    x_points, y_points = [], []
    current_k, current_b = 0, 0

    points, = ax.plot(x_points, y_points, "xb")
    line, = ax.plot(
        [-plot_radius, plot_radius],
        [linear_function(current_k, current_b, -plot_radius), linear_function(current_k, current_b, plot_radius)], "r")

    def on_click(event):
        global current_k, current_b

        x_new_point, y_new_point = ax.transData.inverted().transform([event.x, event.y])
        x_points.append(x_new_point)
        y_points.append(y_new_point)

        points.set_xdata(x_points)
        points.set_ydata(y_points)

        current_k, current_b = gradient_descent(
            x_points, y_points, current_k, current_b,
            step, n_max_iters, eps)

        line.set_data(
            [-plot_radius, plot_radius],
            [linear_function(current_k, current_b, -plot_radius), linear_function(current_k, current_b, plot_radius)])

        fig.canvas.draw()

    fig.canvas.mpl_connect('button_press_event', on_click)
    plt.show()
