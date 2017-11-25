def grey_scale_image(image):
    h = [0] * 256
    for i in range(len(image)):
        for j in range(len(image[i])):
            h[image[i][j]] += 1
    return h


image = [[60, 60, 130, 0], [110, 110, 130, 60], [110, 160, 255, 130]]
print grey_scale_image(image)
