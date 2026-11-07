// 1. All information about each product
db.products.find()

// 2. Price between 400 and 800
db.products.find({ product_price: { $gte: 400, $lte: 800 } })

// 3. Price NOT between 400 and 600
db.products.find({ $or: [{ product_price: { $lt: 400 } }, { product_price: { $gt: 600 } }] })

// 4. Four products with price greater than 500
db.products.find({ product_price: { $gt: 500 } }).limit(4)

// 5. Product name and material of each product
db.products.find({}, { product_name: 1, product_material: 1, _id: 0 })

// 6. Product with row id 10
db.products.find({ id: "10" })

// 7. Only product name and material
db.products.find({}, { product_name: 1, product_material: 1, _id: 0 })

// 8. Material contains "soft"
db.products.find({ product_material: { $regex: "soft", $options: "i" } })

// 9. Color indigo and price 492.00
db.products.find({ product_color: "indigo", product_price: 492 })

// 10. Delete products with price 28
db.products.deleteMany({ product_price: 28 })