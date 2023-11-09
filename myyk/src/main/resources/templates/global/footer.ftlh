<!DOCTYPE html>

<div class="container-fluid">
	<div class="mobile-footer row mx-auto">
		<div class="col <@if category == 'MEMORY' 'selected-header' 'mobile-footer-color'/>">
			<i class="bi bi-images main-bi d-block mx-auto mb-1"></i>
			<@input "category.memory"/>
		</div>
		<div class="col <@if category == 'WISH_PLACE' 'selected-header' 'mobile-footer-color'/>">
			<i class="bi bi-pin-map-fill main-bi d-block mx-auto mb-1"></i>
			<@input "category.wishPlace"/>
		</div>
		<div class="col <@if category == 'MAP' 'selected-header' 'mobile-footer-color'/>">
			<i class="bi bi-map main-bi d-block mx-auto mb-1"></i>
			<@input "category.map"/>
		</div>
		<#--
		<div class="col <@if category == 'REQUEST' 'selected-header' 'mobile-footer-color'/>">
			<i class="bi bi-patch-question main-bi d-block mx-auto mb-1"></i>
			request
		</div>
		-->
		<div class="col <@if category == 'ACCOUNT' 'selected-header' 'mobile-footer-color'/>" data-location="/account/book/dashboard">
			<i class="bi bi-calculator main-bi d-block mx-auto mb-1"></i>
			<@input "category.account"/>
		</div>
		<div class="col <@if category == 'CALENDAR' 'selected-header' 'mobile-footer-color'/>">
			<i class="bi bi-calendar3 main-bi d-block mx-auto mb-1"></i>
			<@input "category.calendar"/>
		</div>
	</div>
</div>

<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
	<div class="col-md-6 d-flex align-items-center">
		<a href="/" class="mb-3 me-2 mb-md-0 text-decoration-none lh-1 primary-dark-color">
			<i class="bi bi-bootstrap-fill "></i>
		</a>
		<span class="primary-dark-color-not-hover pe-none">&copy; 2022 Company, Inc</span>
	</div>

	<ul class="nav col-md-6 justify-content-end list-unstyled d-flex">
		<li class="ms-3"><a class="text-muted primary-dark-color" href="#"><i class="bi bi-twitter"></i></a></li>
		<li class="ms-3"><a class="primary-dark-color" href="#"><i class="bi bi-instagram"></i></a></li>
		<li class="ms-3"><a class="text-muted primary-dark-color" href="#"><i class="bi bi-facebook"></i></a></li>
	</ul>
</footer>
  
<!-- 로딩 모달 -->
<div class="loading-spinner">
	<div class="spinner-border text-info" style="width: 3rem; height: 3rem;" role="status">
		<span class="visually-hidden">Loading...</span>
	</div>
</div>
<!-- Modal -->
<div id="loading-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true"></div>

<script>
$('.mobile-footer div').on('click', function(e)	{
	location.href=$(this).data('location');
});
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>