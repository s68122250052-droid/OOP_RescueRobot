

## ทำไม Java สืบทอดหลาย class ไม่ได้

เพราะจะเกิดปัญหา Diamond Problem
ทำให้ไม่รู้ว่าจะใช้ method จาก class ไหน

---

## เราแก้ปัญหาอย่างไร

เราใช้ interface หลายตัวแทนการสืบทอดหลาย class

RescueRobot implements:
- Flyable
- Drivable
- ThermalSensor
- Communicable

---

## การแก้ปัญหา method ชื่อชนกัน

Flyable และ Drivable มี status() เหมือนกัน

เราจึง override ใน RescueRobot และเรียก

Flyable.super.status()
Drivable.super.status()

---

## Composition

RescueRobot มี
- Battery
- GPSTracker
- ThermalCamera


