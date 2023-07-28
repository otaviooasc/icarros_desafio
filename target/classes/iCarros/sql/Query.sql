SELECT OrderID, 
	SUM(UnitPrice * Quantity) AS TotalPrice 
FROM OrderItems INNER
	JOIN Customers ON OrderItems.CustomerID = Customers.CustomerID
WHERE Customers.CustomerName = 'DeathStar' 
GROUP BY OrderID;