package top.shahow.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_borrowform")
public class BorrowFrom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name = "product_num")
	private int productNum;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "borrower")
	private Borrower borrower;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "delivery_date")
	private Date borrowDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "expect_date")
	private Date expectDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "repay_date")
	private Date repayDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getExpectDate() {
		return expectDate;
	}
	public void setExpectDate(Date expectDate) {
		this.expectDate = expectDate;
	}
	public Date getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

}
